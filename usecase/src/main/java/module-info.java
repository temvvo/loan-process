module loanprocess.usecase {
	requires loanprocess.domain;
	requires lombok;
	requires spring.context;
	requires spring.beans;
	exports com.loanprocess.usecase.calculation;
	exports com.loanprocess.usecase.port;
	exports com.loanprocess.usecase;

}
