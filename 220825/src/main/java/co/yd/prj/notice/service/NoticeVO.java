package co.yd.prj.notice.service;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;
	private String noticeAttech;
	private String noticeAttechdir;
	
	
}
