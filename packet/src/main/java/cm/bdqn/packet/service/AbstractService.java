package cm.bdqn.packet.service;

import cm.bdqn.packet.domain.Book;
import cm.bdqn.packet.domain.BookQry;
import io.jsonwebtoken.lang.Assert;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.util.Loggers;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
@Service
public  class AbstractService {

    private Logger logger=Logger.getLogger(AbstractService.class.getName());


    protected static Map<String, Book> repositoryBook = new HashMap<>();

    public AbstractService() {
        super();
    }

    @PostConstruct
    public void init() {
        // 1
        Book book1 = new Book("1", "name_1", 11, new Date());
        repositoryBook.put(book1.getId(), book1);
        // 2
        Book book2 = new Book("2", "name_2", 11, new Date());
        repositoryBook.put(book2.getId(), book2);
        // 3
        Book book3 = new Book("3", "name_3", 11, new Date());
        repositoryBook.put(book3.getId(), book3);
        // 4
        Book book4 = new Book("4", "name_4", 11, new Date());
        repositoryBook.put(book4.getId(), book4);
    }

    /**
     * cacheNames 设置缓存的值
     *  key：指定缓存的key，这是指参数id值。 key可以使用spEl表达式
     * @param id
     * @return
     */
    @Cacheable(cacheNames="book1", key="#id")
    public Book queryBookCacheable(String id){
        logger.info("queryBookCacheable,id={}"+id);
        return repositoryBook.get(id);
    }

    /**
     * 这里使用另一个缓存存储缓存
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames="book2", key="#id")
    public Book queryBookCacheable_2(String id){
        logger.info("queryBookCacheable_2,id={}"+id);
        return repositoryBook.get(id);
    }

    /**
     * 缓存的key也可以指定对象的成员变量
     * @param qry
     * @return
     */
    @Cacheable(cacheNames="book3", key="#qry.id")
    public Book queryBookCacheableByBookQry(BookQry qry){
        logger.info("queryBookCacheableByBookQry,qry={}"+qry);
        String id = qry.getId();
        Assert.notNull(id, "id can't be null!");
        String name = qry.getName();
        Book book = null;
        if(id != null){
            book = repositoryBook.get(id);
            if(book != null && !(name != null && book.getName().equals(name))){
                book = null;
            }
        }
        return book;
    }


    /**
     * 以上我们使用默认的keyGenerator，对应spring的SimpleKeyGenerator
     *  如果你的使用很复杂，我们也可以自定义myKeyGenerator的生成key
     *
     *  key和keyGenerator是互斥，如果同时制定会出异常
     *  The key and keyGenerator parameters are mutually exclusive and an operation specifying both will result in an exception.
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames="book4",  keyGenerator="myKeyGenerator")
    public Book queryBookCacheableUseMyKeyGenerator(String id){
        logger.info("queryBookCacheableUseMyKeyGenerator,id={}"+id);
        return repositoryBook.get(id);
    }



}
