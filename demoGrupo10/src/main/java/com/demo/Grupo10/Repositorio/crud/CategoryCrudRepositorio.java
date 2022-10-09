/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Repositorio.crud;

import com.demo.Grupo10.Modelo.Category;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Diseño Compass
 */
public interface CategoryCrudRepositorio extends CrudRepository<Category, Integer> {
    
}
