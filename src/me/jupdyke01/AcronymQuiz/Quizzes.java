package me.jupdyke01.AcronymQuiz;

public enum Quizzes {
	AFK("Away From Keyboard"),
	IDK("I Don't Know"),
	IDC("I Don't Care"),
	IDRK("I Don't Really Know"),
	LOL("Laughing Out Loud"),
	ROFL("Rolling On Floor Laughing"),
	TY("Thank You"),
	LTNS("Long Time No See"),
	POS("Parents Over Shoulder"),
	BBL("Be Back Later"),
	BBS("Be Back Soon"),
	BTW("By The Way"),
	BRB("Be Right Back"),
	HAGN("Have A Good Night"),
	KIT("Keep In Touch"),
	NOYB("None Of Your Buisness"),
	OMG("Oh My God"),
	PM("Private Message"),
	TTYL("Talk To You Later"),
	NP("No Problem"),
	TYVM("Thank You Very Much"),
	WTG("Way To Go"),
	BF("Boyfriend"),
	GF("Girlfriend"),
	GJ("Good Job"),
	GMTA("Great Minds Think Alike"),
	YW("Your Welcome"),
	BFF("Best Friends Forever"),
	BFFL("Best Friends For Life"),
	FYI("For Your Information"),
	AKA("Also Known As"),
	DND("Do Not Disturb"),
	POV("Point Of View"),
	HF("Have Fun"),
	IMO("In My Opinion"),
	IOW("In Other Words"),
	TGIF("Thank God It's Friday"),
	TBC("To Be Continued"),
	TYT("Take Your Time"),
	JK("Just Kidding");
	
	

	private String answer;

	private Quizzes(String answer) {
		this.answer = answer;
	}

	public String Answer() {
		return answer;
	}
}
