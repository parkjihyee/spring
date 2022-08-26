package co.yd.prj.notice.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yd.prj.notice.map.NoticeMapper;
import co.yd.prj.notice.service.NoticeService;
import co.yd.prj.notice.service.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper map; // 얘를 호출하면 컨테이너에서 알아서 불어와달라?
	
	@Override
	public List<Map<String, Object>> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearch(String key, String val) {
		return map.noticeSearch(key, val);
	}

	@Override
	public int noticeHitUpdate(NoticeVO vo) {
		return map.noticeHitUpdate(vo);
	}

}
