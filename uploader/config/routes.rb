ActionController::Routing::Routes.draw do |map|
  map.root :controller => "uploader"
  map.connect ':controller/:action/:id'
  map.connect ':controller/:action/:id.:format'
end
