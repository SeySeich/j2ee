package ru.seyseich.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.seyseich.domain.entities.Order;

public interface OrderRepository extends IRepository< Order >
{
	@Query( "select o from Order o where o.customer.id = :customerId and o.id = :id" )
	public List< Order > getOrdersByCustomerIdAndId( @Param( "id" ) Integer id, @Param( "customerId" ) Integer customerId  );
}
