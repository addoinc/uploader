class UploaderController < ApplicationController
  self.allow_forgery_protection = false
  
  def index
  end
  
  def upload
    logger.info("#################")
    params.keys.grep( /payload_\d+/ ).each {
      |key|
      params[key].each {
        |line|
        logger.info( params[key].lineno.to_s + " : " + line)
      }
    }
    logger.info("#################")
    render :text => "OK"
  end

  def zugsfeed
    render :file => RAILS_ROOT + "/public/Zugslist.lua"
  end
  
end
