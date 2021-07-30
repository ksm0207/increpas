package example0729;

public class Library {
	
	Books []  b_items;
	
	public void initBooks() {
		// Flower [] items = new Flower[5];
		b_items = new Books [8];
		for (int i=0; i< b_items.length; i++) {
			b_items[i] = new Books();
			switch (i) {
			case 0:
				b_items[i].setName("자바바이블");
				b_items[i].setPublishing("한빛아카데미");
				b_items[i].setLocation("A-15");
				b_items[i].setCheck(false);
				break;
			case 1:
				b_items[i].setName("자바의정석");
				b_items[i].setPublishing("도우출판사");
				b_items[i].setLocation("A-10");
				b_items[i].setCheck(true);
				break;
			case 2:
				b_items[i].setName("점프 투 자바");
				b_items[i].setPublishing("이지스 퍼블리싱");
				b_items[i].setLocation("A-9");
				b_items[i].setCheck(true);
				break;
			case 3:
				b_items[i].setName("어서와 Java는 처음이지!");
				b_items[i].setPublishing("인피니티북스");
				b_items[i].setLocation("A-15");
				b_items[i].setCheck(false);
				break;
			case 4:
				b_items[i].setName("PHP & Mysql");
				b_items[i].setPublishing("인피니티북스");
				b_items[i].setLocation("B-25");
				b_items[i].setCheck(true);
				break;
			case 5:
				b_items[i].setName("점프 투 파이썬");
				b_items[i].setPublishing("한빛아카데미");
				b_items[i].setLocation("B-2");
				b_items[i].setCheck(true);
				break;
			case 6:
				b_items[i].setName("점프 투 장고");
				b_items[i].setPublishing("이지스 퍼블리싱");
				b_items[i].setLocation("B-8");
				b_items[i].setCheck(false);
				break;
			case 7:
				b_items[i].setName("C언어본색[열혈강의]");
				b_items[i].setPublishing("프리렉");
				b_items[i].setLocation("B-13");
				b_items[i].setCheck(true);
				break;	
			}
			
		}
	}

	public void getFindBooks(String books) {
		String res = "";
		boolean flag = false;
	
		for (int i=0; i<b_items.length; i++) {
			if (b_items[i].getName().contains(books)) {
				if (!b_items[i].isCheck()){
					res = "대여중";
				}else {
					res = "대여가능";
				}
				flag = true;
				System.out.println(b_items[i].getName() + " | " + b_items[i].getPublishing()
						+ " | "+ b_items[i].getLocation() + " | " + res);
			}else {
				if (!flag) {
					System.out.println("찾으시는 결과가 없습니다.");
					break;					
				}
			}
			// end of if-else
		}// end of for loop(1)
	}

	public String isRental(String books) {
		
		StringBuffer sb = new StringBuffer();
		Books book;
		
		for (int i=0; i<b_items.length; i++) {
			book = b_items[i];
			if (b_items[i].getName().contains(books)) {
				if (b_items[i].isCheck()) {
					sb.append(book.getName());
					sb.append("  ");
					sb.append(book.getPublishing());
					sb.append("  ");
					sb.append(book.getLocation());
					sb.append("\n");
				}
			}else {
				
			}
		}// end of for loop(1)
	
		return sb.toString();
	}
}


