lazy val root = Project("root", file("."))
  .aggregate(core, common, consoleClient, examples)
  .disablePlugins(sbtassembly.AssemblyPlugin)

lazy val core = Project("core", file("core"))
  .dependsOn(common)
  .settings(BaseSettings.coreSettings: _*)
  .settings(Dependencies.core: _*)
  .settings(Testing.settings: _*)
  .settings(Assembly.coreAssemblySettings: _*)

lazy val common = Project("common", file("common"))
  .settings(BaseSettings.defaultSettings: _*)
  .settings(Dependencies.common: _*)
  .settings(Testing.settings: _*)
  .disablePlugins(sbtassembly.AssemblyPlugin)

lazy val consoleClient = Project("console-client", file("console-client"))
  .dependsOn(common)
  .settings(BaseSettings.defaultSettings: _*)
  .settings(Dependencies.console: _*)
  .settings(Testing.settings: _*)
  .settings(Assembly.consoleAssemblySettings: _*)

lazy val webClient = Project("web-client", file("web-client"))
  .dependsOn(common)
  .settings(BaseSettings.defaultSettings: _*)
  .settings(Dependencies.web: _*)
  .settings(Testing.settings: _*)
//  .settings(Assembly.webAssemblySettings: _*)
  .disablePlugins(sbtassembly.AssemblyPlugin)

lazy val mockClient = Project("mock-client", file("mock-client"))
  .dependsOn(common)
  .settings(BaseSettings.defaultSettings: _*)
  .settings(Dependencies.mock: _*)
  .settings(Testing.settings: _*)
//  .settings(Assembly.mockAssemblySettings: _*)
  .disablePlugins(sbtassembly.AssemblyPlugin)

lazy val remoteClient = Project("remote-client", file("remote-client"))
  .dependsOn(common)
  .settings(BaseSettings.defaultSettings: _*)
  .settings(Dependencies.remoteClient: _*)
  .settings(Testing.settings: _*)
  .settings(Assembly.remoteClientAssemblySettings: _*)

lazy val remoteServer = Project("remote-server", file("remote-server"))
  .dependsOn(common)
  .settings(BaseSettings.defaultSettings: _*)
  .settings(Dependencies.remoteServer: _*)
  .settings(Testing.settings: _*)
  .settings(Assembly.remoteServerAssemblySettings: _*)

lazy val examples = Project("examples", file("examples"))
  .dependsOn(core, common, consoleClient, webClient, mockClient, remoteClient)
  .settings(BaseSettings.exampleSettings: _*)
  .settings(Assembly.exampleAssemblySettings: _*)


