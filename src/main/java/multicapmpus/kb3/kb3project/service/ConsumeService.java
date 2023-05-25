package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;

import java.util.List;

public interface ConsumeService {

    public List<ConsumeForFeed> getConsumesForFeed(int groupNo);  //해당 그룹의 모든 소비글 가져오기(+댓글 개수, 좋아요수)

    public int increaseLike(int consumeNo);  //해당 소비글의 좋아요 수 증가

    public ConsumeWithUserName getConsumeByConsumeNo(int consumeNo);  //해당 소비글 불러오기 in 댓글 모달창

    public List<ConsumeWithUserName> getConsumes(int groupNo);  //그룹의 모든 소비글 조회 - 사용X
}
