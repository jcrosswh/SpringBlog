package us.xwhite.spring.blog.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Tag;

/**
 *
 * @author Joel
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
