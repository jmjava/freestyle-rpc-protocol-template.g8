git aaddCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M11" cross CrossVersion.full)

version in ThisBuild := "0.1.2-SNAPSHOT"


// required for the RPC Server:
libraryDependencies += "io.frees" %% "frees-rpc-server"            % "0.14.1"

// required for a protocol definition:
libraryDependencies += "io.frees" %% "frees-rpc-client-core"       % "0.14.1"

// required for the use of the derived RPC Client/s, using either Netty or OkHttp as transport layer:
//libraryDependencies += "io.frees" %% "frees-rpc-client-netty"      % "0.14.1"
// or:
//libraryDependencies += "io.frees" %% "frees-rpc-client-okhttp"     % "0.14.1"

// optional - for both server and client configuration.
libraryDependencies += "io.frees" %% "frees-rpc-config"            % "0.14.1"

lazy val root = project
  .in(file("."))
  .settings(name := "freestyle-protocol")
  .settings(scalaMetaSettings: _*)

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}

