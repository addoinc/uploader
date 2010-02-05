ActionController::Routing::Routes.draw do |map|
  map.resources :zugslist, :collection => { :upload => :post, :zugsfeed => :get }
  map.connect ':controller/:action/:id'
  map.connect ':controller/:action/:id.:format'
end
