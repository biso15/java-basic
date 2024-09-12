package last.file;

public class FileTest {
    public static void main(String[] args) {

        // 자바의 대부분의 정보는 객체라는 형태로 구조화(얼려져)되어 있다.
        // 파일은 기본적으로 텍스트로 저장된다.
        // 자바의 객체를 바로 텍스트로 저장 불가능.
        // 자바의 객체를 먼저 텍스트(문자)화 시켜야 함. => 직렬화(Serializable)
        // 텍스트를 불러와서 자바의 객체 형태로 만드는 것 => 역직렬화(Deserializable)
        // ObjectOutputStream, ObjectInputStream은 보안성, 호환성 문제로 지양
        // Jackson 이나 Gson을 많이 사용
        // jackson은 매개변수가 없는 기본 생성자 함수를 필요로 함

        // 객체 직렬화 -> jackson 라이브러리를 이용해 객체를 json 문자화하기
        Post p = new Post(1, "title1", "content1", "20240912", 0);

        JsonUtil ju = new JsonUtil();
        FileUtil fu = new FileUtil();

        String jsonString = ju.toJsonString(p); // p 객체를 json 문자열로 직렬화
        fu.save(jsonString, "test.json");  // 직렬화된 p를 text.json 파일에 저장

        String content = fu.load("test.json");

        //Post post = ju.toPost("test.json");  // text.json 파일의 json 문자열을 p 객체로 변환
        Post post = ju.toPost(content);

        System.out.println("제목 : " + post.getTitle());  // 문자열을 Post로 객체화(역직렬화)
        System.out.println("내용 : " + post.getBody());


        // [예제]
        Member m = new Member("hkd1234", "kd1234", "홍길동");

        String jsonString2 = ju.toJsonString(m);
        fu.save(jsonString2, "member.json");

        String content2 = fu.load("member.json");
        Member member = ju.toMember(content2);

        System.out.println("닉네임 : " + member.getNickname());

    }
}
