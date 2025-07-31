package bean;

public class Question {

	private int id;
	private String text;
	private int score;

	public Question(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {

		if (score < 0 || score > 3) {
			throw new IllegalArgumentException("評価は0～3段階で入力してください");
		}

		this.score = score;
	}

}
