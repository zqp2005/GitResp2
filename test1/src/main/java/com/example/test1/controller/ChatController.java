package com.example.test1.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.deepseek.DeepSeekChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class ChatController {

    @Autowired
    private DeepSeekChatModel chatModel; //与deepseek聊天的对象

    @GetMapping("/generate")
    public String generate(@RequestParam(value = "message",defaultValue = "你是谁？") String message) {
        System.out.println("message = "+message);

        //与模型直接对话，调用 chatModel.call方法
        String resp = chatModel.call(message);

        System.out.println("返回内容："+resp);

        return resp;

    }

    @GetMapping("/generateStream1")
    public Flux<ChatResponse> generateStream1(@RequestParam(value = "message",defaultValue = "你是谁？") String message) {
        System.out.println("message = "+message);

        //与模型对话，流式返回内容
        Prompt prompt = new Prompt(new UserMessage(message));
        Flux<ChatResponse> stream = chatModel.stream(prompt);

        System.out.println("返回内容："+stream);

        return stream;

    }
    @GetMapping("/generateStream2")
    public Flux<String> generateStream2(
            @RequestParam(value = "message",defaultValue = "你是谁？") String message,
            HttpServletResponse response
    ) {


        //设置字符为utf-8编码，避免乱码
        response.setCharacterEncoding("UTF-8");

        System.out.println("message = "+message);

        //与模型对话，流式返回内容
        Prompt prompt = new Prompt(new UserMessage(message));
        Flux<ChatResponse> stream = chatModel.stream(prompt);

        Flux<String> resp = stream.map(
                chatResponse -> chatResponse.getResult().getOutput().getText()
        );

//        Flux<String> resp = stream.map(new Function<ChatResponse, String>() {
//            @Override
//            public String apply(ChatResponse chatResponse) {
//                return chatResponse.getResult().getOutput().getText();
//            }
//        });

        System.out.println("返回内容："+resp);

        return resp;

    }


    @GetMapping("/runtimeOptions")
    public String runtimeOptions(
            @RequestParam(value = "message",defaultValue = "你是谁？") String message,
            @RequestParam(value = "temp" ,required = false) Double temp){

        System.out.println("收到消息："+message+",temp = "+temp);

        Prompt prompt ;
        if(temp !=null){
            System.out.println("使用传入的temp...");
            DeepSeekChatOptions build = DeepSeekChatOptions.builder()
                    .temperature(temp)
                    .build();

            prompt = new Prompt(message, build);
        }else{
            System.out.println("使用默认的 temp...");
            prompt = new Prompt(message);
        }

        ChatResponse resp = chatModel.call(prompt);

        return resp.getResult().getOutput().getText();

    }
}
