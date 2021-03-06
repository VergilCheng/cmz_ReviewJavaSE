/**
 * 模板方法模式：
 * 定义了一个操作中的算法顾家，将某些步骤延迟到子类中实现。这样，新的子类可以在
 * 不改变一个算法结构的前提下重新定义该算法的某些特定步骤
 *
 * 核心：
 * 处理某个流程的代码已经都具备，但是其中某个结点的代码暂时不能确定。因此，我们采用工厂方法模式，
 * 将这个结点的代码实现转移给子类完成。即：处理步骤父类中定义好，具体实现延迟到子类中定义。
 */
package GOF.template_method;