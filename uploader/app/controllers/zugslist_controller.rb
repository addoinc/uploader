class WowdetectController < ApplicationController
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

  def feed
    send_file(RAILS_ROOT + "/public/WOW_LUA_ADDON.lua")
  end
 
end
