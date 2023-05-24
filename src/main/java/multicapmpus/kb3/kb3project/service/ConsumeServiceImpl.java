package multicapmpus.kb3.kb3project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import multicapmpus.kb3.kb3project.DataNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsumeServiceImpl implements ConsumeService {

	private final ConsumeMapper csmMapper;

//	public ConsumeServiceImpl(ConsumeMapper csmMapper) {
//		this.csmMapper = csmMapper;
//	}

	@Override
	public List<Consume> getConsumeList() {
		return csmMapper.getAll();
	}

	@Override
//<<<<<<< HEAD
//	public Consume getConsumeDetail(int c_no) {
//		Optional<Consume> csm = this.csmMapper.findByCno(c_no);
//		if (csm.isPresent()) {
//			return csm.get();
//		} else {
//			throw new DataNotFoundException("Not Found");
//		}
//=======
	public List<Consume> getDayConsume(long user_no, String date) {
		System.out.println(date);
		return mapper.getDayConsume(user_no, date);

	}

	@Override
	public void create(String date, int amount, int category, String memo, String photo) {
		// date type String to LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);

		Consume csm = new Consume();
		csm.setUser_no(1); // 수정필요
		//csm.setC_date(date);
		csm.setC_date(localDate);
		csm.setC_money(amount);
		csm.setC_categoryid(category);
		csm.setC_content(memo);
		csm.setC_image(photo);
		this.csmMapper.save(csm);

	}

//	@Override
//	public List<Consume> getConsumeListByDate(String c_date) {
//		return csmMapper.findByDate(c_date);
//	}

	@Override
	public List<Consume> getConsumeListByDate(String c_date, HttpSession session, Model model) {
		return csmMapper.findByDate(c_date, (int) session.getAttribute("user_no"));
	}

//////////////////////////////////////////////////ys
	@Override
	public List<Consume> getMonthConsume(int user_no, String date) {
		return csmMapper.getMonthConsume(user_no, date);
	}

	@Override
	public List<Consume> getDayConsume(int user_no, String date) {
		return csmMapper.getDayConsume(user_no, date);
	}

	@Override
	public int[] getSum(List<Consume> consumes) {

		int[] arr = new int[32];
		arr[0] = 0;

		for (Consume consume : consumes) {
			arr[0] += consume.getC_money();
			arr[consume.getC_date().getDayOfMonth()] += consume.getC_money();
		}

		return arr;
	}
}
