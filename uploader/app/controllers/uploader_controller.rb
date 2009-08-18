class UploaderController < ApplicationController
  self.allow_forgery_protection = false
  
  def index
  end

  def upload
    logger.info("#################")
    params[:payload].each {
      |line|
      logger.info( params[:payload].lineno.to_s + " : " + line)
    }
    logger.info("#################")
    render :text => "OK"
  end
  
end
