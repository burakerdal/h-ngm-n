import java.util.Random;

public class Game {

	Random rnd = new Random();
	private int score;
	private int random;
	private int wrongGuess;
	private int tahminhakký;
	private int doldu;
	private String hintstr;
	private LinkedQueue game;
	private LinkedQueue board;
	private LinkedQueue word;
	private LinkedQueue missing;
	private LinkedQueue hint;

	public Game() {

		score = 0;
		doldu = 0;
		random= 0;
		wrongGuess = 0;
		tahminhakký = 5;
		hintstr="";
	}

	public String getHintstr() {
		return hintstr;
	}

	public void setHintstr(String hintstr) {
		this.hintstr = hintstr;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getWrongGuess() {
		return wrongGuess;
	}

	public void setWrongGuess(int wrongGuess) {
		this.wrongGuess = wrongGuess;
	}

	public int getTahminhakký() {
		return tahminhakký;
	}

	public void setTahminhakký(int tahminhakký) {
		this.tahminhakký = tahminhakký;
	}

	public int getDoldu() {
		return doldu;
	}

	public void setDoldu(int doldu) {
		this.doldu = doldu;
	}

	public LinkedQueue getGame() {
		return game;
	}

	public void setGame(LinkedQueue game) {
		this.game = game;
	}

	public LinkedQueue getBoard() {
		return board;
	}

	public void setBoard(LinkedQueue board) {
		this.board = board;
	}

	public LinkedQueue getWord() {
		return word;
	}

	public void setWord(LinkedQueue word) {
		this.word = word;
	}

	public LinkedQueue getMissing() {
		return missing;
	}

	public void setMissing(LinkedQueue missing) {
		this.missing = missing;
	}

	public LinkedQueue getHint() {
		return hint;
	}

	public void setHint(LinkedQueue hint) {
		this.hint = hint;
	}

	public void choose(LinkedQueue game, LinkedQueue board, LinkedQueue word, LinkedQueue missing,LinkedQueue hint) {
		this.game = game;
		this.board = board;
		this.word = word;
		this.missing = missing;
        this.hint=hint;
	}

	public void step1() {
		if (board.size() == 0) {
			String str = "";
			random = rnd.nextInt(game.size());
			int size1 = game.size();
			int size2 = hint.size();
			for (int i = 0; i < size1; i++) {
				if (i == random) {
					str = (String) game.peek();
				}
				game.enqueue(game.dequeue());

			}
            
			for (int i = 0; i < size2; i++) {
				if (i == random) {
					hintstr = (String) hint.peek();
				}
				hint.enqueue(hint.dequeue());

			}

			
			for (int i = 0; i < str.length(); i++) {
				if (str.substring(i, i + 1).equals(" ")) {
					board.enqueue(" ");
				} else {
					board.enqueue("-");
				}

			}
			for (int i = 0; i < str.length(); i++) {
				word.enqueue(str.substring(i, i + 1));

			}

		} else {
			delete(board);
			delete(word);
			step1();
		}

	}

	public void delete(LinkedQueue q) {
		while (q.size() != 0) {
			q.dequeue();

		}

	}

	public void run(String input) {
		int full = 0;
		boolean boardcontrol = false;
		if (!boardcontrol) {
			boardcontrol = true;
		}

		int size2 = word.size();
		int boards = board.size();
		boolean miscontrol = false;

		for (int i = 0; i < boards; i++) {
			if (input.equals(board.peek().toString())) {
				// System.out.println("You entered the same letter before.");
				boardcontrol = false;
				break;
			}

			board.enqueue(board.dequeue());
		}

		if (boardcontrol) {
			for (int i = 0; i < size2; i++) {

				if (input.equals(word.peek().toString())) {

					board.dequeue();
					board.enqueue(input);
					miscontrol = true;
					full++;
					score += 5;
				} else {
					board.enqueue(board.dequeue());

				}
				word.enqueue(word.dequeue());

			}

			if (miscontrol == false) {
				int size4 = missing.size();
				for (int i = 0; i < size4; i++) {
					if (input.equals(missing.peek().toString())) {
						miscontrol = true;
					}
					missing.enqueue(missing.dequeue());

				}
				if (miscontrol == false) {
					missing.enqueue(input);
					wrongGuess++;
					tahminhakký--;
					score -= 5;
				}

			}
		}
		doldu = full;

	}

}
