package br.com.fred.aopintercept.aspect;

import br.com.fred.aopintercept.model.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BehaviorAspect {

    @Around("@annotation(br.com.fred.aopintercept.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("****** AOP HERE: " + joinPoint.getSignature() + " executed in " + executionTime + " ms.");
        return proceed;
    }

    /**
     * This aspect was created so as to modify the type passed as cripto string into something
     * the method is expecting
     */
    @Around("@annotation(br.com.fred.aopintercept.annotation.CryptoEncapsulation)")
    public Object encapsulateWithCriptography(ProceedingJoinPoint joinPoint) throws Throwable {
        String headerCrypto = (String) joinPoint.getArgs()[1];
        Object proceed = joinPoint.proceed();
        ResponseEntity<Person> responseEntity = (ResponseEntity<Person>) proceed;
        responseEntity.getHeaders().add("cryptoNew", "Something else decrypted");
        System.out.println(">>> Header crypto: " + headerCrypto);
        System.out.println(">>> Added new header to the response");
        return proceed;
    }
}
