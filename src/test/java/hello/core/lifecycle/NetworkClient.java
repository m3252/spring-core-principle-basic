package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient { // implements InitializingBean, DisposableBean
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("url = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close = " + url);
    }

    // 의존관계 주입이 끝나면 설정해준다.


    @PostConstruct // best practice
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }


    @PreDestroy // best practice - jsr 250 java 표준 인터페이스
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
