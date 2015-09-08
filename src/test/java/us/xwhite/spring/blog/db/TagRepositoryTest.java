/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.xwhite.spring.blog.db;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import us.xwhite.spring.blog.domain.Author;
import us.xwhite.spring.blog.domain.Tag;

/**
 *
 * @author Joel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:blog/db/jpa/RepositoryTest-context.xml")
public class TagRepositoryTest {

    @Autowired
    TagRepository tagRepository;

    @Test
    @Transactional
    public void testCount() {
        assertEquals(5, tagRepository.count());
    }

    @Test
    @Transactional
    public void findOne() {
        Tag tag = tagRepository.findOne(4);
        assertEquals(4, (long) tag.getId());
        assertEquals("sci-fi", tag.getName());
        assertEquals(1, tag.getArticles().size());
        assertEquals("Star Wars vs. Star Trek", tag.getArticles().get(0).getTitle());
    }

    @Test
    @Transactional
    public void findAll() {
        List<Tag> allTags = tagRepository.findAll();
        assertEquals(5, allTags.size());
        for (int i = 0; i < allTags.size(); i++) {
            assertEquals((long) (i + 1), (long) allTags.get(i).getId());
        }
    }

    @Test
    @Transactional
    public void save() {
        assertEquals(5, tagRepository.count());
        Tag tag = new Tag("technology");
        Tag saved = tagRepository.save(tag);
        assertEquals(6, tagRepository.count());
        assertEquals(6, (long) saved.getId());
        assertEquals(6, (long) tagRepository.findOne(6L).getId());
    }
}
