package poly.dto;

/**
 * @author 
 * @version 1.1 페이징 DTO
 */
public class PagingDTO {

	private int page_num; //현재 페이지 번호
	private int total_count; // total row count
	private int page_count; // 페이지별 출력될 row수.
	
	public int getPage_num() {
		return page_num;
	}
	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getPage_count() {
		return page_count;
	}
	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}
}