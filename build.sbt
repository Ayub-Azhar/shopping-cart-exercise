name := """shopping-cart-exercise"""
organization := "com.example"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.8"

libraryDependencies += "org.scalatest"     %% "scalatest"  % "3.2.9"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
