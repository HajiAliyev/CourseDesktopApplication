package az.lesson.course.model;

public class Lesson extends CourseModel {

	private String lessonName;
	private double lessonPrice;
	private Integer lessonTime;

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public double getLessonPrice() {
		return lessonPrice;
	}

	public void setLessonPrice(double lessonPrice) {
		this.lessonPrice = lessonPrice;
	}

	public Integer getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(Integer lessonTime) {
		this.lessonTime = lessonTime;
	}

	@Override
	public String toString() {
		return "Lesson [lessonName=" + lessonName + ", lessonPrice=" + lessonPrice + ", lessonTime=" + lessonTime + "]";
	}

}
