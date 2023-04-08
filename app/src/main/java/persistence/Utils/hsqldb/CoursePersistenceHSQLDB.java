package persistence.Utils.hsqldb;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Course;
import persistence.Utils.CoursePersistence;

public class CoursePersistenceHSQLDB implements CoursePersistence {

    private final String dbPath;

    public CoursePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Course fromResultSet(final ResultSet rs) throws SQLException {
        final String courseID = rs.getString("courseID");
        final String courseName = rs.getString("name");
        final String coursePrice = rs.getString("prices");
        return new Course(courseID, courseName, coursePrice);
    }

    @Override
    public List<Course> getCourseSequential() {
        final List<Course> courses = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM courses");
            while (rs.next())
            {
                final Course course = fromResultSet(rs);
                courses.add(course);
            }
            rs.close();
            st.close();

            return courses;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Course> getCourseRandom(Course currentCourse) {
        final List<Course> courses = new ArrayList<>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM courses WHERE courseID=?");
            st.setString(1, currentCourse.getCourseID());

            final ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                final Course course = fromResultSet(rs);
                courses.add(course);
            }
            rs.close();
            st.close();

            return courses;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Course insertCourse(Course currentCourse) {
        try {
            Connection c = connection();
            final PreparedStatement st = c.prepareStatement("INSERT INTO courses VALUES(?, ?, ?)");
            st.setString(1, currentCourse.getCourseID());
            st.setString(2, currentCourse.getCourseName());
            st.setString(3, currentCourse.getCoursePrice());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.e("Retry", "SQLException: "+throwables.toString() );
        }
        return currentCourse;

    }

    @Override
    public Course updateCourse(Course currentCourse) {

        try   {
            Connection c = connection();
            final PreparedStatement st = c.prepareStatement("UPDATE courses SET name = ? , prices = ? WHERE courseID = ?");
            st.setString(1, currentCourse.getCourseName());
            st.setString(2, currentCourse.getCourseID());
            st.setString(3, currentCourse.getCoursePrice());

            st.executeUpdate();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return currentCourse;
    }

    @Override
    public void deleteCourse(Course currentCourse) {

        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM studentscourses WHERE courseID = ?");
            sc.setString(1, currentCourse.getCourseID());
            sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM courses WHERE courseID = ?");
            st.setString(1, currentCourse.getCourseID());
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
