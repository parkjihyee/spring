package co.yd.prj.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService { // list, map 객체를 이용해서 
	// JOIN 또는 vo객체 안 만들고 사용할때
	List<Map<String,Object>> noticeSelectList(); //타입에 구애받지않으려고 object 
	
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(String key, String val); // 제목에 어떤 단어가 포함되어있으면 다 불러오라
	
}
