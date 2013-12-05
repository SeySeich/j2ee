package ru.seyseich.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository< T > extends JpaRepository< T, Integer >
{
	// Empty
}
