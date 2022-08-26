package co.yd.prj.notice.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import co.yd.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	@Select("select * from notice") //select 사용 권장하진 않지만 간단한건 해도 괜찮음
	List<Map<String,Object>> noticeSelectList(); // JOIN 또는 vo객체 안 만들고 사용할때
	
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(NoticeVO vo); // 조회수 증가
	
	//                                  속성 명               사용할 변수 명    val의 타입
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val);
	//mapper interface에서 전달인자가 둘 이상이면 반드시 @Param 사용. mapper에서 인식할 수 있게 하기 위해.
}
