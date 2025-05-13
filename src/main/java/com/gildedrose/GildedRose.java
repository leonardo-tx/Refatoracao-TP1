package com.gildedrose;

import com.gildedrose.updaters.ItemUpdater;
/*
* Explicação pedida (Também se encontra no PDF)
* 1 - A estrutura atual facilita a adição de novos tipos de item? Justifique com base no Princípio Aberto-Fechado.
* Sim. Ao colocar um novo ItemUpdater, é necessário apenas criar uma nova classe que utilize a interface ItemUpdater e
* adicionar o caso de nome ao ItemUpdaterFactory, isso permite que não haja a necessidade de modificação do código
* existente, apenas uma extensão dela, o que facilita a adição de novas estratégias de atualização de itens, como
* no caso dos itens conjurados.
*
* 2 - A implementação dos ItemUpdater respeita o Princípio da Responsabilidade Única? Explique.
* Sim. A implementação dos ItemUpdater respeita o princípio da responsabilidade única por justamente ser responsável
* por apenas atualizar os atributos dos itens após um ciclo, diferente de antes onde tudo era feito na classe
* GlidedRose.
*
* 3 - Alguma violação do Princípio de Substituição de Liskov pode ser identificada em sua hierarquia? Se sim, corrija-a.
* Não. O princípio de Substituição de Liskov está sendo respeitado, já que não há nenhuma subclasse que modifica o
* comportamento de uma classe / interface base.
 */
public class GildedRose {
    private final Item[] items;
    private final ItemUpdaterFactory factory;

    public GildedRose(ItemUpdaterFactory factory, Item[] items) {
        this.items = items;
        this.factory = factory;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = factory.createItemUpdater(item);
            updater.updateItem(item);
        }
    }
}
