class UploaderController < ApplicationController
  def index
  end

  def upload
    logger.info( params.inspect )
  end
end
