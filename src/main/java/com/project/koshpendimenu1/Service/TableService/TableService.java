package com.project.koshpendimenu1.Service.TableService;

import com.project.koshpendimenu1.Model.Tables;
import com.project.koshpendimenu1.Repository.TableRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableService implements ITableService {

    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    // Add a new table
    @Override
    public Tables addTable(Tables table) {
        return tableRepository.save(table);
    }

    // Update an existing table
    @Override
    public Tables updateTable(Long id, Tables updatedTable) {
        if (tableRepository.existsById(id)) {
            updatedTable.setId(id); // Ensure the ID is set for update
            return tableRepository.save(updatedTable);
        }
        return null; // or throw an exception if the table does not exist
    }

    // Delete a table by ID
    @Override
    public void deleteTable(Long id) {
        if (tableRepository.existsById(id)) {
            tableRepository.deleteById(id);
        }
    }

    // Fetch a table by ID
    @Override
    public Optional<Tables> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    // Fetch all tables
    @Override
    public Iterable<Tables> getAllTables() {
        return tableRepository.findAll();
    }
}
