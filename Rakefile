require 'rake'

java_home = ENV["JAVA_HOME"]
java_home = "~/java/jdk1.5.0_15"

task :clean do
  sh %{rm -f Uploader.jar Uploader.class}
end

task :build => :clean do
  sh %{#{java_home}/bin/javac Uploader.java}
end

task :jar => :build do
  sh %{#{java_home}/bin/jar cvf Uploader.jar Uploader.class}
end

task :keytool do
  sh %{#{java_home}/bin/keytool -genkey -alias Uploader -validity 30}
end

task :sign => :jar do
  sh %{#{java_home}/bin/jarsigner Uploader.jar Uploader}
  sh %{cp Uploader.jar libs/}
end

task :default => :jar
