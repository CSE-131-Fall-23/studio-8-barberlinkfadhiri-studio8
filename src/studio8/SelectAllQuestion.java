package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		// Hint: 1 point per choice
		super(prompt, answer, choices.length, choices);
		// FIXME
	}

	@Override
	public int checkAnswer(String givenAnswer) {
		// FIXME Should return partial credit (if earned)!
		int score = this.getPoints()-this.getAnswer().length();
		for (int i = 0; i < givenAnswer.length(); i++) {
			if (getAnswer().contains(String.valueOf(givenAnswer.charAt(i)))) {
				score++;
			}else {
				score--;
			}
		}
		if(score<0) {
			return 0;
		}else {
			return score;
		}
	}

	public static void main(String[] args) {
		String[] choices = { "instance variables", "git", "methods", "eclipse" };
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:",
				"13", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); // no credit
		System.out.println(selectAll.checkAnswer("13")); // full credit
		System.out.println(selectAll.checkAnswer("31")); // full credit
		System.out.println(selectAll.checkAnswer("1")); // 3 points
		System.out.println(selectAll.checkAnswer("3")); // 3 points
		System.out.println(selectAll.checkAnswer("23")); // 2 points
		System.out.println(selectAll.checkAnswer("34")); // 2 points
		System.out.println(selectAll.checkAnswer("4")); // 1 point
		System.out.println(selectAll.checkAnswer("124")); // 1 point
		System.out.println(selectAll.checkAnswer("24")); // 0 points

	}
}
