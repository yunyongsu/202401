package practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		return new MemberInfoPrinter();
	}
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
//	@Bean
//	public VersionPrinter versionPrinter() {
//		VersionPrinter versionPrinter = new VersionPrinter();
//		versionPrinter.setMajoVersion(5);
//		versionPrinter.setMinorVersion(0);
//		return versionPrinter();
//	}
}
