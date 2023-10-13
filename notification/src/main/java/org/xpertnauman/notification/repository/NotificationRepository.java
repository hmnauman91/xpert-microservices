package org.xpertnauman.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xpertnauman.notification.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>
{
}
