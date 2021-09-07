/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.SQLException;
import java.util.List;
import model.Timekeeper;

/**
 *
 * @author Hieu PC
 */
public interface ITimeKeeperDAO {

    public List<Timekeeper> selectAllTimekeepers();

    public boolean deleteTimeKeeper(String id) throws SQLException;

    public boolean updateTimeKeeper(Timekeeper timekeeper) throws SQLException;
}
