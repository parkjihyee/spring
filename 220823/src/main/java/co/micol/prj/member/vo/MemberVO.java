package co.micol.prj.member.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberVO { // table 칼럼 명 = vo 객체 이름
	private String member_id;
	private String member_password;
	private String member_name;
	private String member_author;
}
