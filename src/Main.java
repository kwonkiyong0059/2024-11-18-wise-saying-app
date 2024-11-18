import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Quote {
    private final int id;
    private String content;
    private String author;

    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String formatDetail() {
        return "번호: " + id + "\n명언: " + content + "\n작가: " + author;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();
        int nextId = 1;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("메뉴를 선택하세요.");
            System.out.println("1. 명언 등록 || 2. 번호 조회 || 3. 전체 조회 || 4. 명언 삭제 || 5. 종료");
            System.out.print("명령: ");
            String command = sc.next();

            if (command.equals("1") || command.equalsIgnoreCase("등록")) {
                sc.nextLine(); // 버퍼 비우기
                System.out.print("명언: ");
                String content = sc.nextLine();
                System.out.print("작가: ");
                String author = sc.nextLine();

                quotes.add(new Quote(nextId, content, author));
                System.out.println(nextId + "번 명언이 등록되었습니다.");
                nextId++;
            } else if (command.equals("2") || command.equalsIgnoreCase("번호 조회")) {
                System.out.print("조회할 명언 번호: ");
                int idToFind = sc.nextInt();
                boolean found = false;

                for (Quote quote : quotes) {
                    if (quote.getId() == idToFind) {
                        System.out.println("조회 결과:");
                        System.out.println(quote.formatDetail());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("해당 번호의 명언이 없습니다.");
                }
            } else if (command.equals("3") || command.equalsIgnoreCase("전체 조회")) {
                if (quotes.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    System.out.println("전체 명언 목록:");
                    for (Quote quote : quotes) { // 1번부터 순서대로 출력
                        System.out.println(quote.formatDetail());
                        System.out.println("----------------------");
                    }
                }
            } else if (command.equals("4") || command.equalsIgnoreCase("삭제")) {
                System.out.print("삭제할 명언 번호: ");
                int idToDelete = sc.nextInt();
                boolean found = false;

                for (int i = 0; i < quotes.size(); i++) {
                    if (quotes.get(i).getId() == idToDelete) {
                        quotes.remove(i);
                        System.out.println(idToDelete + "번 명언이 삭제되었습니다.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("해당 번호의 명언이 없습니다.");
                }
            } else if (command.equals("5") || command.equalsIgnoreCase("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 명령입니다. 다시 입력해주세요.");
            }
        }

        sc.close();
    }
}
