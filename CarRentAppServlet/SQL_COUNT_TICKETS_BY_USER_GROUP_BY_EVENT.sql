SELECT ticket.id,ticket.code, ticket.event_id, COUNT(ticket.event_id) AS count, SUM(event.price) AS sum 
FROM ticket, event, users
WHERE event.id = ticket.event_id AND users.id=ticket.user_id AND ticket.user_id = 6 
GROUP BY ticket.event_id;