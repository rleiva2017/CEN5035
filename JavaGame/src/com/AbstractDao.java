package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDao {

		protected Connection conn;

		/**
		 * Constructor.
		 * 
		 * @param conn JDBC connection
		 */

		public AbstractDao(final Connection conn) {
			this.conn = conn;
		}

		/**
		 * Closes Statement.
		 * 
		 * @param stmt JDBC Statement
		 */

		public void close(final Statement stmt) {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException se) {
					// nothing
				}
			}
		}

		/**
		 * Closes PreparedStatement.
		 * 
		 * @param pstmt JDBC PreparedStatement
		 */

		public void close(final PreparedStatement pstmt) {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					// nothing
				}
			}
		}

		/**
		 * Closes ResultSet.
		 * 
		 * @param pstmt rs JDBC ResultSet
		 */

		public void close(final ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					// nothing
				}
			}
		}
	}


