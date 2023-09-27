package com.example.codeTamerBack.rest.v1.action.controllers;

import com.example.codeTamerBack.rest.v1.action.interfaces.ActionStatus;
import com.example.codeTamerBack.rest.v1.action.models.Action;
import com.example.codeTamerBack.rest.v1.action.repositories.ActionRepository;
import com.example.codeTamerBack.rest.v1.action.requests.ActionResponseRequest;
import com.example.codeTamerBack.rest.v1.action.responses.ActionResponse;
import com.example.codeTamerBack.rest.v1.action.services.ActionService;
import com.example.codeTamerBack.rest.v1.common.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ActionController {
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ActionService actionService;

    @PostMapping("actions")
    public Action addAction(@RequestBody Action data) throws Exception {
        return actionService.addAction(data);
    }

    @PutMapping("actions/response")
    public Action responseAction(@RequestBody ActionResponseRequest data) throws Exception {
        return actionRepository.save(
                actionService.answerOnAction(data.getStatus(), data.getActionId())
        );
    }

    @DeleteMapping("actions")
    public SuccessResponse deleteAction(@RequestParam(name = "id") String id) throws Exception {
        if(actionRepository.findById(id).isEmpty()) throw new Exception("action not found");
        actionRepository.deleteById(id);
        return new SuccessResponse();
    }

    @GetMapping("actions/list")
    public List<ActionResponse> getActions(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam(name = "status", required = false) ActionStatus status) throws Exception {
        if(status != null) {
            return actionService.getActionsList(token, status);
        } else {
            return actionService.getActionsList(token);
        }
    }
}
