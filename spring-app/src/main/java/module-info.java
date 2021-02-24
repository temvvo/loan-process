module loanprocess.spring {
	requires loanprocess.domain;
	requires loanprocess.usecase;
	requires org.mapstruct.processor;
	requires org.mapstruct;
	requires spring.context;
	requires spring.beans;
	requires spring.boot.autoconfigure;
	requires spring.boot;

	requires lombok;
	requires spring.core;
	requires spring.web;
	requires spring.webmvc;
	requires org.apache.tomcat.embed.core;
	requires java.compiler;

	exports com.loanprocess.handler;
}
