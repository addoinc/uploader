# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_uploader_session',
  :secret      => '532e844642a40ad6e4da44103cee45a865b5f561fa4a4e7ad2ebf190eb84eae66aed959b21f1741d6bb524524233267f6b59edba5e5b2fd8c59e440ce77505ef'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
