package com.project.koshpendimenu1.Service.TableService;

import com.project.koshpendimenu1.Model.Tables;

import java.util.Optional;

public interface ITableService {

    // Add a new table
    Tables addTable(Tables table);

    // Update an existing table
    Tables updateTable(Long id, Tables updatedTable);

    // Delete a table by ID
    void deleteTable(Long id);

    // Fetch a table by ID
    Optional<Tables> getTableById(Long id);

    // Fetch all tables
    Iterable<Tables> getAllTables();
}
