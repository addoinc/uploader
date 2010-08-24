ActionController::Routing::Routes.draw do |map|
  map.resources :wowdetect, :collection => { :upload => :post, :feed => :get }
  map.connect ':controller/:action/:id'
  map.connect ':controller/:action/:id.:format'
end
