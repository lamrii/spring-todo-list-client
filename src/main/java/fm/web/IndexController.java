package fm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller("/")
public class IndexController {

    @GetMapping
    public ModelAndView index() {
        RestTemplate restTemplate = new RestTemplate();

        List<Todo> todos = restTemplate.getForObject("http://localhost:8080/api/todos", List.class);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("todos", todos);

        return mv;
    }

    class Todo {

        private Long id;

        private String message;

        private boolean done;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }
}
