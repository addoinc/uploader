require 'rake'

java_home = ENV["JAVA_HOME"]
#java_home = "~/java/jdk1.5.0_15"

task :clean do
  sh %{rm -f Uploader.jar Uploader.class libs/Uploader.jar uploader/public/libs/Uploader.jar}
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
  sh %{cp Uploader.jar uploader/public/libs/Uploader.jar}
end

task :sign_all do
  [
   "apache-mime4j-0.6.jar", "commons-codec-1.3.jar",
   "commons-logging-1.1.1.jar", "httpclient-4.0.jar",
   "httpcore-4.0.1.jar", "httpmime-4.0.jar",
   "jcip-annotations.jar", "Uploader.jar"
  ].each {
    |jar_file|
    sh %{#{java_home}/bin/jarsigner libs/#{jar_file} Uploader}
  }
end

task :deploy_all_jars do
  [
   "apache-mime4j-0.6.jar", "commons-codec-1.3.jar",
   "commons-logging-1.1.1.jar", "httpclient-4.0.jar",
   "httpcore-4.0.1.jar", "httpmime-4.0.jar",
   "jcip-annotations.jar", "Uploader.jar"
  ].each {
    |jar_file|
    sh %{rm uploader/public/libs/#{jar_file}}
    sh %{cp libs/#{jar_file} uploader/public/libs/#{jar_file}}
  }
end

task :default => :jar
