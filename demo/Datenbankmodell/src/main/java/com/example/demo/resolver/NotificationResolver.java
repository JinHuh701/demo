package com.example.demo.resolver;

import com.example.demo.entity.Notification;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NotificationResolver {

    @Autowired
    private NotificationService notificationService;

    @QueryMapping
    public List<Notification> getNotificationsByUser(@Argument Long userId) {
        return notificationService.getNotificationsByUser(userId);
    }

    @MutationMapping
    public Notification createNotification(@Argument Long userId, @Argument String type, @Argument String content) {
        return notificationService.createNotification(userId, type, content);
    }
}