package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    //    전략패턴과 템플릿 콜백 패턴의 차이 질문
//
//    전략이란 의도를 동일하게 사용하기 때문에 템플릿 콜백 패턴도 전략패턴의 일종인데 차이를 생각해보자면
//    전략패턴은 context의 인스턴스 변수로 전략을 참조하고, 템플릿 콜백 패턴은 context의 관련 메서드로 callback 받는 차이가 있다고 이해하였습니다.
//    이런 차이로 아래 두가지를 생각해보았는데 제대로 이해한 것이 맞을지 궁금하여 질문드립니다.
//        1. 전략패턴은 템플릿 콜백 패턴보다 context와 전략간 의존성이 더 강하단 단점이 있고, 반면에 자주 사용되는 context라면 템플릿 콜백 패턴은 재사용성이 떨어진다는 단점이 있을 것 같습니다.(매번 callback을 정의해주어야하므로)
//        2. 전략패턴은 런타임시 객체가 생성될 때 전략이 정해지고, 템플릿 콜백 패턴은 context가 해당 전략을 실행할 시점에 전략이 정해진다고 정의

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직1 실행"));
        template.execute(() -> log.info("비즈니스 로직2 실행"));
    }



}
