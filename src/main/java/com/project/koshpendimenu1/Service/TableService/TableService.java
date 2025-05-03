

import com.project.koshpendimenu1.Model.Table;
import com.project.koshpendimenu1.Repository.TableRepository;
import com.project.koshpendimenu1.Service.TableService.ITableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService implements ITableService {

    private final TableRepository tableRepository;

    // Add a new table
    @Override
    public Table addTable(Table table) {
        return tableRepository.save(table);
    }

    // Update an existing table
    @Override
    public Table updateTable(Long id, Table updatedTable) {
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
    public Optional<Table> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    // Fetch all tables
    @Override
    public Iterable<Table> getAllTables() {
        return tableRepository.findAll();
    }
}
